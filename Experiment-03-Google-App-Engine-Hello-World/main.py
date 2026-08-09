# Simple Hello World web application for Google App Engine (Python)
from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return '<h1>Hello, World!</h1><p>Running on Google App Engine!</p>'

@app.route('/about')
def about():
    return '<h1>About</h1><p>Simple GAE Python application.</p>'

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=8080)
