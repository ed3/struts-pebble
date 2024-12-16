# struts-pebble

Pebble templates for struts framework (examples included)


Requirement
---

- java 11 or greater
- struts-6.7.0 libraries
- pebble-3.2.2.jar
- if you use java 8 then need to change in `PebbleResult.java` file:

```java
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletResponse;
```

to

```java
import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
```

Dependency
---

- unbescape-1.1.6.RELEASE.jar


Configuration
---

Default values for constants:

```java
struts.pebble.prefix = WEB-INF/templates
struts.pebble.suffix = .html
```

Add constants in struts.xml (optional)
```xml
...
<constant name="struts.pebble.prefix" value="templates" />
<constant name="struts.pebble.suffix" value=".html" />
...
```

or add constants in struts.properties (optional)

```java

struts.pebble.prefix = templates
struts.pebble.suffix = .html
```
