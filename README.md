# Management Service

The Management Service is a abackend service that collects the order from the RabbitMQ message queue. This service display the information about orders.

## Codebase

## Dependency

## Configuration

## Backing Service

## Setup Instructions

### Spring Boot RESTful API

### Azure VM

www

    Project Details
        - Choose Subscriptio
        - Choose resouce group
    Instance details
        -  Ubuntu image
        - size
        - SSH KEY

    After creation
    Confiure the Network Security Group
        - 5672
        - 8080
        - 15672

    start rabbit mq
    - Access vm through ssh key via visual stuido code 
    - Git clone and install

### Set up Azure Web App

Input the settings for

    Project Details
        - Choose Subscriptio
        - Choose resouce group
    Instance details
        - Publish by code, container, static web app
        - Runtime (Java 17 for the SPring boot app)
        - Operating and region (Same as Resouce group region)
        - Pricing plan (Chose BAsic B1)
    Deployment
        - Configure to continnous deployment
        - Connect to github
        - Select reposiotry and branch
    Network Deufalt
    Enable application insight
