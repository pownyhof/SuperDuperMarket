# Super Duper App

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Usage](#usage)
5. [Configuration](#configuration)

## Introduction

Product management system designed to help businesses efficiently track,
manage, and analyze their inventory of products.
It offers features such as adding, updating, and generating reports on product quality, pricing
and expiration dates.

## Features

- 1: Print product information like name, price, quality, expiry date and if it needs to be removed from the assortment
- 2: Add product information via csv files
- 3: Add product information via MySQL

## Prerequisites
Before installing the application, ensure that you have the following prerequisites installed on your system:

- Java Development Kit (JDK) version 9 or higher
- IDE like IntelliJ

## Usage

1. **Clone the Repository:**
   Clone the application repository from the source repository to your local machine using Git:
   ```bash
   git clone <repository_url>
   
2. Run App.main() in `./modules/main/java/app/src/de/superduper/app/Main.java`

## Configuration

Configure MySQL (if required):
If your application requires database functionality,
configure the database connection properties in the config.properties file in `./modules/main/resources/config.properties`
