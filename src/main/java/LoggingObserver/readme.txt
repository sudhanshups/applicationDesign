Functional Requirements:

It should provide,

1. A configurable option for other application modules to save logs at more than
one platform like, on Console, in txt files or on network etc.
2. A Facility to Log messages in different categories like, ERROR, WARNING,
GENERAL_MESSAGES and also provision to control each category independently.
3. A Facility to configure & bind category and Logging platform at run
time i.e. user will be able to specify at runtime that,
    a.  Messages of any particular category should be logged or not etc.
    b.  Messages of any particular category like ERROR should be logged in error.txt and remaining categories on console only etc.



Intent of Observer Design Pattern:

Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

Here, Logger is SUBJECT and Logging Platforms are OBSERVERS. It decouples the sender and receivers i.e it decouples the different Application modules and actual logging platforms.

Logging Platforms registers itself with the Subject (i.e. Logger) on the basis of message types and when Logger (i.e. Subject) receives any message it notifies the Platforms registered with that message type by forwarding the message. Then those platforms take action on that message.