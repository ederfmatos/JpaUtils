# JPA Utils

<p align="center">
	<img src="https://github.com/ederfmatos/JpaUtils/actions/workflows/publish.yml/badge.svg"/>
	<img alt="GitHub stars" src="https://img.shields.io/github/stars/ederfmatos/JpaUtils?style=social">
	<img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/ederfmatos/JpaUtils?style=social">
	<img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/ederfmatos/JpaUtils">
	<img alt="GitHub issues" src="https://img.shields.io/github/issues/ederfmatos/JpaUtils">
	<img alt="GitHub closed issues" src="https://img.shields.io/github/issues-closed/ederfmatos/JpaUtils">
</p>

Essa é uma biblioteca desenvolvida para facilitar a criação de filtros e buscas utilizando [Spring Data JPA](https://spring.io/projects/spring-data-jpa)!  <br>Nela temos algumas funções utilitárias que auxiliam na hora de criar uma "query" no banco de dados.


## Importação

Essa biblioteca está publicada no Github Package Registry, por conta disso deve ser adicionado a chave  de acesso pública ao repositório

**CHAVE_DE_ACESSO:** dee388c6051ee2215beee8e1fbf3985d7b767c61
### Gradle

**Importação do Repositório**	
	
``` gradle
repositories {  
    maven {  
      name = "GitHubPackages"  
      url = uri("https://maven.pkg.github.com/ederfmatos/JpaUtils")  
      credentials {  
        username = "ederfmatos"  
        password = "CHAVE_DE_ACESSO"  
      }  
    }  
}
```

**Importação da biblioteca**

``` gradle
dependencies {
  implementation 'com.exactaworks.JpaUtils:0.0.2'
}
```

### Maven

**Importação do Repositório**	
``` xml
<project>
  <distributionManagement>
    <repository>
      <id>github</id>
      <name>GitHub Packages</name>
      <url>https://maven.pkg.github.com/ederfmatos/JpaUtils</url>
    </repository>
  </distributionManagement>
</project>
```


**Importação da biblioteca**

```xml
<dependency>
  <groupId>com.exactaworks</groupId>
  <artifactId>jpautils</artifactId>
  <version>0.0.2</version>
</dependency>
```
