<br>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#Version">Version</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
<h1 align="center">Web-Server-App</h1>
<br>

![Media Fun Screen Shot1][product-screenshot-1]
screenshot - web-server-app testing1
<br><br>
![Media Fun Screen Shot2][product-screenshot-2]
screenshot - web-server-app testing1
<br><br>

## Project Description ℹ️
This project is a lightweight web server implemented in Java using core networking libraries. It listens for incoming HTTP requests on port 80 and processes them using multi-threading to handle multiple client connections concurrently. The server follows a client-server architecture, where clients (such as web browsers or API consumers) send requests, and the server responds accordingly.
<br><br>

## Features of the Web-Server-App 🚀

1️⃣ . Basic HTTP Request Handling – Accepts and processes client requests over port 80.

2️⃣ . Multi-threaded Processing – Uses threads to handle multiple client connections concurrently.

3️⃣ . Client-Server Architecture – Acts as a server, responding to requests from web browsers or API clients.

4️⃣ . Socket-Based Communication – Utilizes Java’s ServerSocket & Socket API for networking.

5️⃣ . Efficient Request Reading – Uses BufferedReader & InputStreamReader to handle incoming data.

6️⃣ . Logging & Monitoring – Displays client connection details in the console.

7️⃣ . Lightweight & Fast – Minimal dependencies, making it efficient and easy to deploy.

8️⃣ . Extensible – Can be modified to support file serving, REST API requests, or WebSockets.


<br>

## Technologies Used 👩🏻‍💻

### 1. Java:
    * Core language for backend development


### 2. ServerSocket & Socket (Java Networking API) :
    * Manages client connections.


### 3. Multi-threading (Java Threads):
    * Handles multiple requests concurrently.


### 4. BufferedReader & InputStream/ OutputStream:
    * Reads/ Writes client requests efficiently.

### 5. HTTP Request Handling
    * Processes incoming HTTP requests


<p align="right">(<a href="#readme-top">back to top</a>)</p>


### <p align="center">**_Client-Server Architecture_**

This web server follows a client-server model, where:

1. **The server (ServerSocket)** listens on port 80 for incoming connections.


2. A **client** (e.g., browser, Postman, or curl) initiates an HTTP request.


3. The server **accepts the connection** (accept()) and spawns a new thread to handle the request.


4. The server reads the **HTTP request headers** from the client using BufferedReader


5. (Optional) It can process different **HTTP methods** (GET, POST, etc.) and respond accordingly.


6. Once processing is complete, the server sends back an HTTP response and closes the connection.

<br>
<hr>


### Built With 🛠️

The Web-Server App was developed only using the Java language.

![java-url] 
<br><br>


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- GETTING STARTED -->
## Getting Started

Make sure your Integrated Development Environments (IDEs) or Code Editors is working fine in the PC.
It will easy to understand if you've knowledge of,
   * Networking Knowledge - 
     * How Domain Name System (DNS) works, 
     * How HTTP Request/ Response are working

<br>

### Installation 💻

_Below is an example of how you can installing and setting up your app._

1. Clone the repo
   ```bash
   git clone https://github.com/Isuranga-Seram/Web-Server-Simple.git
   cd Web-Server-Simple
   ```

2. Change git remote url to avoid accidental pushes to base project
   ```sh
   git remote set-url origin github_username/repo_name  #optional
   git remote -v # confirm the changes
   ```

3. If 'Apache2' is running in your PC, firstly sto the Apache2 server
   ```sh
   sudo systemctl stop apache2

   ```

4. If maven is not installed in your PC install using this commands,
   ```sh
   sudo apt update
   sudo apt install maven -y

   ```

5. Then run the below command to start the server app on Port: 80
   ```sh
   mvn -q compile && sudo /opt/sdkman/candidates/java/current/bin/java -cp target/classes lk.ijse.dep13.web.server.ServerApp
   ```
   
6. Now you've started the server and, you can redirect any domain to your server app.
   * To check, using ant text-editor open the /etc/hosts file and edit the 'domain name' that you want to redirect and save.
   ```sh
   sudo gnome-text-editor /etc/hosts
   ```
      Ex:-  127.0.0.1  [domain name you prefer]
      
   Use browser and Enter the domain name.
   
   Enjoy !!


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- USAGE EXAMPLES -->
## Usage

The Web-Server app have a variety of uses. Here are some of the main use cases:

1. **Basic Web Server 🌐**
   * Serves static files (HTML, CSS, JS) to clients like web browsers.


2. **API Server for Client Applications 📡**
   * Can handle REST API requests (e.g., GET, POST, PUT, DELETE).


3. **Testing and Learning Purposes 🛠**
   * Helps developers understand network programming, multi-threading, and HTTP request handling.


4. **Local File Sharing Server 📂**
   * Useful for sharing documents, images, or software over a local network.


5. **Educational Tool for Teaching Networking & HTTP 📚**
   * Provides a practical way to experiment with sockets, HTTP headers, and request handling.



<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- CONTRIBUTING -->
## Contributing 👪

🚀 "Great projects thrive on collaboration! Join us in building something amazing—contribute your skills, ideas, and code to make this web server even better!" 💡✨
<br>

### Potential Enhancements :

* Potential Enhancements
* Support multiple HTTP methods (GET, POST, PUT, DELETE).
* Implement logging for request details.
* Add security features like request validation or HTTPS support.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- Version -->
## Version 📳

0.0.1

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- LICENSE -->
## License 

Copyright © 2025 Web-server Application. All Rights Reserved This project is licensed under the [MIT License](LICENSE.txt).
See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- CONTACT -->
## Contact ☎

Isuranga Seram [email] - **_isurangaseram@gmail.com_**

LinkedIn: [linkedin.com/in/isuranga-seram](linkedin.com/in/isuranga-seram)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* "I sincerely appreciate the support and contributions from everyone who helped shape this web server project. Special thanks to the open-source community for inspiring innovation and collaboration." 🚀

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[product-screenshot-1]: img/java-web-server4.png
[product-screenshot-2]: img/java-web-server5.png
[java]: https://www.java.com/en/
[java-url]: https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/121px-Java_programming_language_logo.svg.png

