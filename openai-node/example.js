import OpenAI from 'openai';

const modelgwApiKey = 'sk-...';

const openai = new OpenAI({
  apiKey: modelgwApiKey,
  baseURL: `https://azure-openai.api.modelgw.com/openai/deployments/auto`,
  defaultQuery: { 'api-version': '2023-05-15' },
  defaultHeaders: { 'api-key': modelgwApiKey },
});

async function main() {
  const result = await openai.chat.completions.create({
    model: 'auto',
    messages: [{ role: 'user', content: 'Hello there!' }],
  });
  console.log(JSON.stringify(result, null, 4));
}

main().catch((err) => {
  console.error(err);
  process.exit(1);
});
