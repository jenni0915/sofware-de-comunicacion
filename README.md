# sofware-de-comunicacion
This repository contains three distributed system projects implemented during the Software de Comunicaciones course (2024/2025). Each practice explores a different middleware and distribution technology in Java to transform a monolithic calculator into a client-server system.

Java 17
Apache Thrift 0.20
Java RMI API
Spring Boot 
Maven 
Concurrency: ReentrantReadWriteLock, multithreading

## Practice 1
Objective:
Transform a monolithic calculator into a distributed application using Remote Procedure Calls (RPC) with Apache Thrift.
Key Features:
Implemented memory-based calculator logic in Java.
Created Thrift interface (IDL) and compiled stubs.
Developed single-threaded and multithreaded Thrift servers.
Handled concurrent client access using ReentrantReadWriteLock.

## Practice 2
Objective:
Distribute the same calculator functionality using Java Remote Method Invocation (RMI).
Key Features:
Implemented ICalculadoraRMI interface for remote operations.
Used custom checked exceptions (CalculadoraExcepcion) for division.
Built a server exposing remote calculator objects.
Implemented thread-safe access to shared memory using ReentrantReadWriteLock.

## Practice 3
Objective:
Expose the calculator functionality via REST APIs using Spring Boot.
Key Features:
Created RESTful endpoints for calculator operations.
Implemented JSON-based input/output and error handling.
Built client-server architecture using HTTP communication.
Tested REST services with curl/Postman and Java client adapters.
