import os

import requests

def save_artifact():
    with open(os.path.join(os.environ['ARTIFACTS_PATH'], "example.txt"), 'r') as f:
        f.write("Some artifact")
    return requests.get("http://google.com")


def save_printscreen():
    with open(os.path.join(os.environ['SCREENSHOTS_PATH'], "example.txt"), 'r') as f:
        f.write("Some screenshot")
