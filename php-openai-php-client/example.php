<?php
require __DIR__ . '/vendor/autoload.php';

$modelgwApiKey = 'sk-...';

$client = OpenAI::factory()
    ->withBaseUri('https://azure-openai.api.modelgw.com/openai/deployments/auto')
    ->withHttpHeader('api-key', $modelgwApiKey)
    ->withQueryParam('api-version', '2023-05-15')
    ->make();

$response = $client->chat()->create([
    'model' => 'auto',
    'messages' => [
        ['role' => 'user', 'content' => 'Hello there!'],
    ],
]);

foreach ($response->choices as $result) {
    echo $result->message->content;
}
