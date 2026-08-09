# Experiment 08 - Creating and Executing Your First Docker Container

## Aim
To build and run a custom container using Docker and Dockerfile.

## Prerequisites
- Docker Engine / Docker Desktop (`docker` CLI)

## Files
- `Dockerfile`: Container image definition file.
- `main.py`: Python application executed inside the container.

## How to Run

```bash
# 1. Build Docker image
docker build -t my-first-container .

# 2. Run Docker container
docker run --rm my-first-container
```

## Sample Output
```
Hello from inside Docker Container!
Running Python 3.9 container successfully.
```

## Result
A custom Docker container was created using Dockerfile and executed successfully.
