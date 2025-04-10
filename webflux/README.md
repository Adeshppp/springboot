# Reactive Streams Specification and work flow

![Image](https://github.com/user-attachments/assets/194f0f08-d6a7-4906-8213-9bba61d7b139)


Reactive stream specification is nothing but rules to achieve reactive programming.

It has 4 interfaces as shown above.

1. Publisher or Producer

![Image](https://github.com/user-attachments/assets/65e34443-1b7a-4bea-a7f2-93078843d099)

2. Subscriber or Consumer

![Image](https://github.com/user-attachments/assets/5abfe9c4-8b02-4ac7-b4dd-5405f54a2c53)

3. Subscription

![Image](https://github.com/user-attachments/assets/387c1c4a-40bf-40ac-a5be-6519f2dff23c)

4. Processor

![Image](https://github.com/user-attachments/assets/f96f0a83-d154-4138-a300-8fd03d615b19)


## Reactive flow workflow

![Image](https://github.com/user-attachments/assets/cfeab29f-f9fd-4b84-ae58-2029d8d20616)

### Libraries to design reactive programming:

1. Reactor
2. RxJava
3. Jdk9 Flow reactive stream


# Mono and Flux test

![Image](https://github.com/user-attachments/assets/32a2e8b3-6f71-4b8a-9b3d-acb6481cb2a7)

![Image](https://github.com/user-attachments/assets/406c88d5-8c40-4dd5-842d-fb276be88873)


# Asynchronous and non-blocking 

![Image](https://github.com/user-attachments/assets/0c984e72-26f4-4868-9eae-9862470ca890)

In traditional rest API call when my browser makes the API call to the back end which eventually calls a getCustomer function as shown above it returns a list of customers by gathering all the information so for example here we have added a delay of 1 millisecond after each record gets loaded in order to understand the difference between reactive programming and the normal approach and when we call this API which calls getCustomer function my browser gets response after 50 milliseconds as we are loading 50 records, each with one millisecond of delay so it took around 50 milliseconds to load the page this is the disadvantage of using a regular rest API approach.

![Image](https://github.com/user-attachments/assets/2904a808-8c8b-4ffe-9572-48a21a409b2e)


As you can see in above code I have set up two endpoints in customer controller class customers in which first get all customers function is normal rest API which calls load all customer function in customer service class and that function further calls get customer function in customer dao class, as I said before in normal rest API it takes a time to back end to completely compose a response and once it composes the response then only it will respond back to the client and then only client will list all of the records written by the back end this behavior is synchronous and blocking.

But as we can see we have a second endpoint with the function name as a gate all customers stream which calls load all customer stream in customer service class and that function further calls get customers stream function in customer dao class. As we can see this endpoint makes a use of reactive programming by using web flux but it follows subscriber and consumer pattern in which at soon as fraction of response gets ready it will be written to the client and my web browser will show that fraction of response. This behavior is asynchronous and non blocking as it does not wait for the response to completely compose at the back end whereas it response of fraction of response as soon as it gets ready.


In this approach my browser which is a client is acts as a subscriber and the back end acts as a producer. Here my back end pushes the data for subscriber/consumers to consume.


There is another advantage of using reactive programming, in traditional approach when my browser which is a client makes a API call to the back end and after a while before back end responds with the data if user cancels the request then back end still processes that request, whereas in reactive programming approach if client makes a request and before completing that request if the user decides to cancel the request it will stop the execution of that request at that moment in the back end.
