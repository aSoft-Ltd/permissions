# Permissions

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

A set of libraries for dealing with permissions.

This lib is split into to two

1. Module Permissions
    - Handles Permissions for each module
2. Resource Permissions
    - Handles Permissions for resources (i.e. Files)

## Resource Permissions

- A resource always can be accessed by the owner, a group of people authorized by the owner, and any other.

This means that it has owner claims, group claims, and claims for other accessors

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/permissions-core/0.0.20?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
