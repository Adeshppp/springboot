# Reactive Streams Specification and Workflow

![Reactive Streams Overview](https://github.com/user-attachments/assets/194f0f08-d6a7-4906-8213-9bba61d7b139)

The **Reactive Streams specification** defines a set of rules to achieve reactive programming in a non-blocking, asynchronous manner. It introduces four core interfaces:

---

### 1. Publisher (Producer)

![Publisher](https://github.com/user-attachments/assets/65e34443-1b7a-4bea-a7f2-93078843d099)

---

### 2. Subscriber (Consumer)

![Subscriber](https://github.com/user-attachments/assets/5abfe9c4-8b02-4ac7-b4dd-5405f54a2c53)

---

### 3. Subscription

![Subscription](https://github.com/user-attachments/assets/387c1c4a-40bf-40ac-a5be-6519f2dff23c)

---

### 4. Processor

![Processor](https://github.com/user-attachments/assets/f96f0a83-d154-4138-a300-8fd03d615b19)

---

## Reactive Flow - Workflow

![Reactive Flow Workflow](https://github.com/user-attachments/assets/cfeab29f-f9fd-4b84-ae58-2029d8d20616)

---

## Libraries for Designing Reactive Applications

- **Project Reactor**
- **RxJava**
- **JDK 9 Flow (Reactive Streams API)**

---

## Mono and Flux Testing

![Mono Test](https://github.com/user-attachments/assets/32a2e8b3-6f71-4b8a-9b3d-acb6481cb2a7)  
![Flux Test](https://github.com/user-attachments/assets/406c88d5-8c40-4dd5-842d-fb276be88873)

---

# Asynchronous and Non-Blocking Architecture

![Asynchronous Architecture](https://github.com/user-attachments/assets/0c984e72-26f4-4868-9eae-9862470ca890)

In a **traditional REST API**, when the browser makes a request, the backend synchronously processes the entire response before sending it to the client. For example, if 50 records are fetched with a 1-millisecond delay per record, the client receives the response after approximately 50 milliseconds. This blocking behavior results in slower response times.

---

### Controller Comparison

![REST vs Reactive Controller](https://github.com/user-attachments/assets/2904a808-8c8b-4ffe-9572-48a21a409b2e)

In the above example:

- The first endpoint `/customers` uses a **standard REST API** flow:
    - The controller calls `loadAllCustomers()` in the service.
    - The service calls `getCustomers()` in the DAO.
    - The response is composed **only after all records are retrieved**.
    - **Synchronous and blocking** behavior.

- The second endpoint `/customers/stream` uses **Reactive WebFlux**:
    - The controller calls `loadAllCustomersStream()` in the service.
    - The service calls `getCustomersStream()` in the DAO.
    - Response is streamed to the client **as data becomes available**.
    - **Asynchronous and non-blocking** behavior.

---

### Key Benefits of Reactive Programming

- **Backpressure Support**: The client (browser) acts as a **subscriber**, and the backend acts as a **producer**. The backend pushes data as it becomes available.
- **Efficient Cancellation**: In traditional APIs, if the client cancels the request midway, the backend still continues processing. In reactive systems, the backend **immediately stops processing** if the client cancels the request.
- **Improved Responsiveness**: Partial data is delivered to the client as soon as it's ready, enhancing user experience.
