# struts-pebble

Pebble templates for struts framework (examples included)


Requirement
---

- java 17 or greater (for older version use `java8` branch)
- [struts](https://struts.apache.org) 7 libraries
- [pebble](https://pebbletemplates.io/) 4.1.x.jar


Dependency
---

- [unbescape](https://unbescape.org/) 1.1.6.RELEASE.jar


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
