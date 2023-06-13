# chatgpt-prompt-engineering-app

![inteligenciaaritificial](https://github.com/CarolinaChavezDavid/chatgpt-prompt-engineering-app/assets/77591347/f3ebb9fc-8d04-48cd-b6c2-2193ceefe2fb)

In these repository you can find information about how to design an effective prompt in order to create an application aid by ChatGPT

## Best practices

### LLMS (Large Language Models)
### Base LLM
Predicts new word, based on text training data.
### Instruction Tuned LLM
* Tries to follow instrucctions
* Fine-tune on instructions and good attemps at following those instructions
* It started as Base LLM and then is train with RLHF (ReinforcementLEarning with Human Feedback)
* Helpful, Honest, Harmless

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
It can make statements that sounds plausible but are not true

<img width="400" alt="image" src="https://github.com/CarolinaChavezDavid/chatgpt-prompt-engineering-app/assets/77591347/f60098c0-36c5-4775-8a02-c8b3a592b607"> </br>
Ther isn't a perfect prompt, It's more important to have a process for developing a good prompt for your specific application. 


