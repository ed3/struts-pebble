# struts-pebble

Pebble templates for struts framework (examples included)


Requirement
---

- java 8
- struts-6.7.0 libraries
- pebble-3.2.2.jar


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
