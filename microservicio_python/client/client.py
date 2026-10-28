import requests

BASE_URL = "http://localhost:8000"
EXAMPLE_DNI = "00000000T"

POST_REQUESTS = [
    {
        "url": "/dni/" + EXAMPLE_DNI[0:8],
        "expected_code": 200,
        "expected_value": "T"
    },
    {
        "url": "/dni/" + EXAMPLE_DNI[0:7],
        "expected_code": 400,
    },
    {
        "url": "/dni/" + " ",
        "expected_code": 400,
    },
    {
        "url": "/dni/" + "AAAAAAAA",
        "expected_code": 400,
    }
]

GET_REQUESTS = [
    {
        "url": "/dni/validar?dni=" + EXAMPLE_DNI,
        "expected_code": 200,
        "expected_value": True
    },
    {
        "url": "/dni/validar?dni=" + EXAMPLE_DNI[0:8] + "A",
        "expected_code": 200,
        "expected_value": False
    },
    {
        "url": "/dni/validar?dni=" + EXAMPLE_DNI[0:8],
        "expected_code": 400,
    },
    {
        "url": "/dni/validar?dni=" + " ",
        "expected_code": 400,
    },
    {
        "url": "/dni/validar?dni=" + "AAAAAAAAA",
        "expected_code": 400,
    },
]

if __name__ == '__main__':
    incorrect_responses = []
    correct_responses = 0

    for request in POST_REQUESTS:
        response = requests.post(BASE_URL + request["url"])
        if (response.status_code == 200 and response.json()["letra"] == request["expected_value"])\
                or (response.status_code == request["expected_code"]):
            correct_responses += 1
        else:
            incorrect_responses.append({
                "request": request,
                "response": response
            })

    for request in GET_REQUESTS:
        response = requests.get(BASE_URL + request["url"])
        if (response.status_code == 200 and response.json()["valido"] == request["expected_value"]) \
                or (response.status_code == request["expected_code"]):
            correct_responses += 1
        else:
            incorrect_responses.append({
                "request": request,
                "response": response
            })

    print("Total correct responses: ", correct_responses)
    print("Incorrect responses: ", incorrect_responses)