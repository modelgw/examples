from openai import AzureOpenAI

MODELGW_API_KEY = "sk-..."

client = AzureOpenAI(
    api_key=MODELGW_API_KEY,
    api_version="2023-05-15",
    azure_endpoint="https://azure-openai.api.modelgw.com", # set endpoint
)

completion = client.chat.completions.create(
    messages=[{"role": "user", "content": "Hello there!"}],
    model="auto",  # set your model to "auto"
)

print(completion)
