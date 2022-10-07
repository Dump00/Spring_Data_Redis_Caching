# Spring Data Redis

<br>

## Intro

Redis is driven by a **keystore-based data structure to persist data and can be used as a database, cache, message broker**, etc.

We'll be able to use the common patterns of Spring Data (templates, etc.) while also having the traditional simplicity of all Spring Data projects.

## The Redis Configuration

To define the connection settings between the application client and the Redis server instance, we need to use a Redis client.


Here we'll use **Jedis — a simple and powerful Redis client implementation**.


Using the Jedis client, we're defining a **connectionFactory**.

## Caching

1. `@EnableCaching`
2. `@Cacheable`
3. `@CachePut`
4. `@CacheEvict`

We will add caching in the DAO layer using **@CachePut, @CacheEvict, @Cacheable, @Caching** annotations.

The reason we are going to use the DAO layer for caching is that **sometimes we need to do some operations on results in the service layer based on parameters passed or we can call the same methods from different locations**. It’s better to maintain a separate DAO layer for caching purposes and others too.

**Define TTLs:** Time-to-live (TTL), is the time span after which your Cache will be deleting an entry. If you want to fetch data only once a minute, just guard it with a @Cacheable Annotation and set the TTL to 1 minute.

**Implement Serializable:** If you are adding an object in Redis cache then the object should implement a Serializable interface.

**Redis Cache Limits:** When cache size reaches the memory limit, old data is removed to make a place for a new one. Although Redis is very fast, it still has no limits on storing any amount of data on a 64-bit system. It can only store 3GB of data on a 32-bit system.
## source

[Introduction to Spring Data Redis](https://www.baeldung.com/spring-data-redis-tutorial)

[A Guide To Caching in Spring](https://www.baeldung.com/spring-cache-tutorial)