# Spring Data Redis

<br>

## Intro

Redis is driven by a **keystore-based data structure to persist data and can be used as a database, cache, message broker**, etc.

We'll be able to use the common patterns of Spring Data (templates, etc.) while also having the traditional simplicity of all Spring Data projects.

## The Redis Configuration

To define the connection settings between the application client and the Redis server instance, we need to use a Redis client.


Here we'll use **Jedis — a simple and powerful Redis client implementation**.


Using the Jedis client, we're defining a **connectionFactory**.

## source

[Introduction to Spring Data Redis](https://www.baeldung.com/spring-data-redis-tutorial)
