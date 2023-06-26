# chatgpt-prompt-engineering-app

![inteligenciaaritificial](https://github.com/CarolinaChavezDavid/chatgpt-prompt-engineering-app/assets/77591347/f3ebb9fc-8d04-48cd-b6c2-2193ceefe2fb)
GPT (Generative Pre-Trained Transformer)

In this repository, you can find information about how to engineer an effective prompt in order to create an application aid by ChatGPT

 GPT is a language model based on a deep neural network architecture capable of identifying our language and generate coherent and contextually relevant responses. It is a genealogical model, given a text, it can generate words

## Best practices

### LLMS (Large Language Models)
### Base LLM
Predicts new words based on text training data.
### Instruction Tuned LLM
* Tries to follow instructions
* Fine-tune on instructions and make good attempts at following those instructions
* It started as Base LLM and then was trained with RLHF (Reinforcement Learning with Human Feedback)
* Helpful, Honest, and Harmless

## Principle of Prompting
* Principle 1: Write clear and specific instructions
  * Tactic 1: Use delimiters to clearly indicate distinct parts of the input
  * Tactic 2: Ask for a structured output
  * Tactic 3: Ask the model to check whether conditions are satisfied
  * Tactic 4: "Few-shot" prompting
 
* Principle 2: Give the model time to think
  * Tactic 1: Specify the steps required to complete a task
  * Tactic 2: Instruct the model to work out its own solution before rushing to a conclusion

## Model Limitations
* Hallucinations
It can make statements that sound plausible but are not true

<img width="400" alt="image" src="https://github.com/CarolinaChavezDavid/chatgpt-prompt-engineering-app/assets/77591347/f60098c0-36c5-4775-8a02-c8b3a592b607"> </br>
There isn't a perfect prompt, It's more important to have a process for developing a good prompt for your specific application.

## Prompt engineering
Prompt engineering is a relatively new discipline for developing and optimizing prompts to efficiently use language models (LMs) for a wide variety of applications and research topics. 


## Sources of information
[🔗](https://www.deeplearning.ai/short-courses/chatgpt-prompt-engineering-for-developers/) **ChatGPT Prompt Engineering for Developers** course from Open IA 
[🔗](https://www.promptingguide.ai/)**Prompt Engineering Guide**

