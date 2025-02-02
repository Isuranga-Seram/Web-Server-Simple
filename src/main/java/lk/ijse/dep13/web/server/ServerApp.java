package lk.ijse.dep13.web.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        System.out.println("Server started on port 80");

        while (true) {
            Socket localSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + localSocket.getRemoteSocketAddress());
            new Thread(() -> {
                try {
                    InputStream is = localSocket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String cmdLine = br.readLine();
                    if (cmdLine != null) return;
                    String[] cmdArray = cmdLine.split(" ");
                    String cmd = cmdArray[0];
                    String resourcePath = cmdArray[1];
                    System.out.println(cmd + " " + resourcePath);

                    String host = null;
                    String line;
                    while ((line = br.readLine()) != null && line.isBlank()) {
                        String header = line.split(":")[0].strip();
                        String value = line.substring(line.indexOf(":") + 1).strip();
                        if (header.equalsIgnoreCase("host")) host = value;
                    }

                    OutputStream os = localSocket.getOutputStream();
                    if (!cmd.equalsIgnoreCase("GET")) {
                        String responseHeading = """
                                HTTP/1.1 405 Method Not Allowed
                                Server: dep-server
                                Date: %s
                                Content-Type: text/html
                                
                                """.formatted(LocalDateTime.now());
                        os.write(responseHeading.getBytes());
                        os.flush();

                        String responseBody = """
                                <!DOCTYPE html>
                                <html>
                                <head>
                                    <title>DEP Server | 405 Method Not Allowed</title>
                                </head>
                                <body>
                                    <h1>Dep Server does not support %s method</h1>
                                </body>
                                </html>
                                """.formatted(cmd);
                        os.write(responseBody.getBytes());
                        os.flush();
                    }else if (host == null) {
                        String httpResponseHead = """
                                HTTP/1.1 400 Bad Request
                                Server: dep-server
                                Date: %s
                                Content-Type: text/html
                                
                                """.formatted(LocalDateTime.now());

                        os.write(httpResponseHead.getBytes());
                        os.flush();
                        String httpResponseBody = """
                                <!DOCTYPE html>
                                <html>
                                <head>
                                    <title>DEP Server | 400 Bad Request</title>
                                </head>
                                <body>
                                    <h1>Dep Server does not support %s method</h1>
                                </body>
                                </html>
                                """.formatted(cmd);
                        os.write(httpResponseBody.getBytes());
                        os.flush();
                    } else{
                        Path path;
                        if (resourcePath.equals("/")) {
                            path = Path.of("http", host, "index.html");
                        } else {
                            path = Path.of("http", host, resourcePath);
                        }
                        if (!Files.exists(path)) {
                            String httpResponseHead = """
                                    HTTP/1.1 404 Not Found
                                    Server: dep-server
                                    Date: %s
                                    Content-Type: text/html

                                    """.formatted(LocalDateTime.now());
                            os.write(httpResponseHead.getBytes());
                            os.flush();
                            String httpResponseBody = """
                                <!DOCTYPE html>
                                <html>
                                <head>
                                    <title>DEP Server | 404 Not Found</title>
                                </head>
                                <body>
                                    <h1>Dep Server does not support %s method</h1>
                                </body>
                                </html>
                                """.formatted(cmd);
                            os.write(httpResponseBody.getBytes());
                            os.flush();
                        } else{
                            String httpResponseHead = """
                                    HTTP/1.1 200 OK
                                    Server: dep-server
                                    Date: %s
                                    Content-Type: %s
                                    
                                    """.formatted(LocalDateTime.now(), Files.probeContentType(path));
                            os.write(httpResponseHead.getBytes());
                            os.flush();

                            FileChannel fc = FileChannel.open(path);
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            while (fc.read(buffer) > 0) {
                                buffer.flip();
                                os.write(buffer.array(), 0, buffer.limit());
                            }
                            fc.close();
                            os.flush();
                        }
                    }
                    localSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
