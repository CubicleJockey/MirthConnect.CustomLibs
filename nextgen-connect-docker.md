# MirthConnect Docker Setup:
Docker Image:
https://hub.docker.com/r/nextgenhealthcare/connect?uuid=3CF63052-D2BB-4502-902C-4B2450840AB4

# Default with embedded Derby database
1. Run: docker run --name MirthConnect -d -p 8443:8443 nextgenhealthcare/connect
2. Url: https://localhost:8443/
3. Download: Administrator Launcher
4. Default User:
   U: admin
   P: admin
5. Set new password 'demo'



Custom Libraries Directory in Docker Container:
```
File System
    -opt
      |
      |-connect
          |
          |-custom-lib
```