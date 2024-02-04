curl "https://azure-openai.api.modelgw.com/openai/deployments/auto/chat/completions?api-version=2023-05-15" \
    -H "Content-Type: application/json" \
    -H "api-key: $MODELGW_API_KEY" \
    -d "{ \"messages\": [{ \"role\": \"user\", \"content\": \"Hello there\!\" } ], \"model\": \"auto\" }"
