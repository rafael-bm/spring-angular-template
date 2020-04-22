## Spring and Angular Sample

template project used to be used as template for new projects

### configurations

- Spring boot
- Spring MVC
- Thymeleaf template
- Angular 8

### Project Structure

- backend
    Holds spring boot java code, where contain the main spring boot server
- frontend
    Angular source code.
- frontend_dist

### Building commands

1 - Build front end statics

```bash
make frontend-build-prod
```
2 - Start spring boot

```bash
make service-run
```

### Developing commands

1 - in a new terminal, start backend stub

```bash
make backend-stub-run
```

2 - in a separate terminal, start angular application 

```bash
make frontend-run
```

### Context path

The default context path for spring boot is `myappname`. in order to change it, 
is necessary a replacement in some files:

backend
- application.yml on `server.servlet.context-path`

makefile
 - Makefile on command `frontend-build-prod`
