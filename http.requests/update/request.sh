curl --request PUT -sL \
    --header "Content-Type: application/json"\
    --data '{
            "task":"Change of plans, order KFC rather",
            "isDone":true
    }'\
    --url 'http://localhost:8080/todos/1' \
     --output './response.json' -v