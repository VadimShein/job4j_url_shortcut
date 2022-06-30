[![Build Status](https://travis-ci.org/VadimShein/job4j_url_shortcut.svg?branch=master)](https://travis-ci.org/VadimShein/job4j_url_shortcut)

# <p align="center">Url Shortcut</p>

### Description:
The service shortens user links and provides convenient and quick access to them.
First, the user registers the site and receives a login and password, then sends links for conversion. 
The number of hits on the converted link is counted and displayed as statistics.

### Used technologies:
* Java 11
* Spring Boot 2
* Spring Security & JWT authorization
* Spring Data JPA
* PostgreSQL

### Using REST API

#### Register site

![ScreenShot](./images/registration.PNG)

#### Get token

![ScreenShot](./images/get_token.PNG)

#### Convert link

![ScreenShot](./images/convert_link.PNG)

#### Redirection. Executed without authorization.

![ScreenShot](./images/redirection.PNG)

#### Getting statistic

![ScreenShot](./images/get_statistic.PNG)