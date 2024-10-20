# Management Service

The Management Service is a backend service that collects the order from the RabbitMQ message queue. This service display the information about orders that is fetch from RabbitMQ.

### Task Completed

1. This application successfully gets order messages from RabbitMQ and utilizes Azure App Service to expose the REST API that the store-admin web app can use to view orders.
2. This application fully complied with the first four factors of the 12-Facto principles:

   - **Codebase**: The application project is tracked in Git version control in a `single repository`.
   - **Dependencies**: All dependencies are `declared` in `pom.xml`. This isolates all the libraries that the application depends on for better representation. Having all dependencies declared in one single file allows for easier management and updation.
   - **Config**: `All sensitive` data are `separate from code` and stored in the environment. This approach allows for the better securing of sensitive data that is important to the application.
   - Backing Service: I set up the REST API to connect to RabbitMQ this is a great representation of a `backing service that the application consumer over the network`.

3. After testing the application locally, I deployed the `management-service` to `Azure Web App Service`, which involved configuring the web app and setting up the necessary `environment variables`. Once deployed, I tested the service to verify its accessibility and confirmed that it successfully receives orders from RabbitMQ. The `.github/workflows` generated while deploying the service shows a successful deployment.

## Setup Instructions

### Spring Boot RESTful API

I utilize `Spring Boot` to create a `RESTful API` that interacts with `RabbitMQ` to collect orders from the message queue. This service processes incoming `GET requests` from the client to provide their specific GET request.

#### Development Workflow

1. Initialized a Spring Boot application for the project, I set up the necessary structure and dependencies.

2. Configured RabbitMQ to establish a connection with the message broker.

3. I created a RabbitMQ component that listens to the RabbitMQ queue. The RabbitComp class handles all operations related to order management, including retrieving all orders and fetching specific order details.

4. Developed the Product model and the Order model to represent the structure of orders in the system.

5. Implemented a service application that calls functions from the RabbitMQ component to perform specific operations, such as retrieving orders.

6. Designed a Controller class to manage incoming requests, ensuring that they are routed to the appropriate service methods for processing and response generation.

7. Deployed the application to Azure Web App Service, to run in a cloud environment and make it accessible.

### Endpoints

`spring_api/orders`<br>
This endpoint retrieves a list of all orders in the system, providing an overview of all order details.

`spring_api/orders/id={order_id}`<br>
This endpoint retrieves detailed information about a specific order using the order ID, allowing `store-front` to access order items and quantities.

`spring_api/orders/for={food_for}`<br>
This endpoint filters orders based on the food type parameter, specifically for "Dog," "Cat," or "Bird." It enables `store-front` to quickly organize orders.

### Azure VM

I deployed an Azure VM to run RabbitMQ. With RabbitMQ installed, the web application can efficiently handle message queues.

1. Chose the resource group created for this project, located in Canada Central.

2. Select the Ubuntu 22.04 image as the operating system for the VM.

3. Specify the desired VM size.

4. Generate and configure an SSH key for secure access to the VM.

5. After creating the VM, I adjust the Network Security Group settings to allow traffic on the following ports:

   - Port 5672 for RabbitMQ communication.
   - Port 8080 for Store Front.
   - Port 15672 for accessing the RabbitMQ management interface.

   ![alt text](/images/inboundrules.png)

6. Access the VM using the SSH key through Visual Studio Code. Once connected, I install, configured, and run the RabbitMQ.

### Set up Azure Web App

I deployed the management service `directly from code` to the Azure Web App Service. I made sure the service is easily accessible and can seamlessly retrieve orders from the RabbitMQ running on the Azure VM.

1. Chose the appropriate subscription for th project and then select the resource group.

2. The runtime is set to Java 17 for the Spring Boot application.

3. I chose the cheapest pricing plan that would allow me to implment continous deployment.

4. Configure the environment for continuous deployment by connecting to my GitHub account and selecting the application project.

5. After successful deployment, I configure the environment variables within the web app sevrice to allow access.
   ![alt text](/images/config.png)

## Testing with Postman

I used Postman to test all the endpoints, using the URL provided by the Azure Web App Service `https://managementservice-gwdgbfgdbtdabcfj.canadacentral-01.azurewebsites.net`, ensuring that each operation was successful and functioning as intended. This involved sending requests to each endpoint and carefully checking the responses to verify that the data was processed and showed the order information.

`spring_api/orders`<br>

![alt text](/images/allorders.png)

`spring_api/orders/id={order_id}`<br>

![alt text](/images/byidorder.png)

`spring_api/orders/for={food_for}`<br>

![alt text](/images/byfood.png)

To test the REST service locally, I ran the Spring Boot application directly within the IntelliJ IDE. By using Postman, I sent HTTP requests to the endpoints, checking the responses and ensuring that the service was functioning as expected.

## References

[Spring Boot – RabbitMQ Configuration](https://www.geeksforgeeks.org/spring-boot-rabbitmq-configuration/)

### AI

- Debugging
- Deployment process
- Clarifying tasks
- Grammatical error for ReadMe.md
