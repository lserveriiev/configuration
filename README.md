# Configuration parser and reader
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](MIT)
[![Build Status](https://travis-ci.com/serveriev/configuration.svg?branch=master)](https://travis-ci.com/serveriev/configuration)

> Parse and read configurations in java. This package covers only parsing the configuration properties files 
> and resolving the environment variables in these files.

## Install

This package didn't upload to the maven central repository. Thus, for using this dependency you can use [Jitpack.io](https://jitpack.io/).

### 1. Add the Jitpack repository to pom.xml

```sh
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### 2. Add the di dependency to pom.xml

```sh
<dependency>
    <groupId>com.github.serveriev</groupId>
    <artifactId>configuration</artifactId>
    <version>v1.0</version>
</dependency>
```

## How to use

### 1. Add a configuration file to the resource folder.

### 2. Load and read configuration. 

```java
import io.lenur.configuration.Configuration;

public class Application {

    public static void main(String[] args) {
        Configuration configuration = new Configuration("application.properties");
        System.out.println(configuration.get("database.username"));
        System.out.println(configuration.get("database.url"));
    }
}
```

## Issues

✅ Parsing property files

❌ Parsing yaml files

❌ Parsing xml file

✅ Resolving environment variables

❌ Resolving system variables


## Author

**Lenur**

* Github: [@serveriev](https://github.com/serveriev)

## License

Copyright © 2020 [Lenur](https://github.com/serveriev).

This project is [MIT](MIT) licensed.