from locust import HttpUser, task, between

class MyUser(HttpUser):
    wait_time = between(1, 2)
    host = "http://server1:5000"  # Define el host base aquí para servidor1

    @task
    def index(self):
        self.client.get("/")
