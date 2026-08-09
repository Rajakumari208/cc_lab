# Experiment 03 - Google App Engine Hello World

## Aim
To install Google App Engine, create a Hello World web application using Python/Java, and deploy it locally and to Google Cloud.

## Software Requirements
- Python 3.9+ or Java JDK 8/11
- Google Cloud SDK (`gcloud` CLI)
- Flask / Google App Engine Python Runtime

## Files
- `main.py`: Flask web application routing logic.
- `app.yaml`: Google App Engine deployment configuration file.
- `requirements.txt`: Python package dependencies.

## How to Run

### 1. Run Locally
```bash
pip install -r requirements.txt
python main.py
```
Open browser at `http://localhost:8080`

### 2. Deploy to Google App Engine
```bash
gcloud app deploy
gcloud app browse
```

## Sample Output
```
Hello, World!
Running on Google App Engine!
```

## Result
Google App Engine environment was configured, and the Hello World Python application was successfully created, tested locally, and deployed.
