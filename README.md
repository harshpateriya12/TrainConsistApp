**KEY CONCEPTS**

LinkedHashSet – A hash table and linked list implementation of the Set interface that stores unique elements while maintaining the exact insertion order of bogies in the train formation.
Set Interface – A collection type in Java that does not allow duplicate elements, ensuring that the same bogie cannot be attached more than once in the train consist.
add() Method – Inserts a bogie into the formation. If the bogie already exists, the method ignores the insertion automatically, protecting the train from invalid duplicate attachments.
Automatic Deduplication – LinkedHashSet removes duplicate bogies internally without requiring manual validation logic from the developer.
Insertion Order Preservation – Unlike HashSet, LinkedHashSet maintains the sequence in which bogies are added, allowing the train consist to reflect the real physical attachment order.
Ordered Iteration – When iterating or printing the collection, bogies are returned in the same order they were connected to the engine.

**KEY BENEFITS**

Enforces real-world business rules by preventing duplicate bogies.
Preserves physical attachment sequence of the train.
Demonstrates how Java combines ordering with uniqueness.
Helps students understand when LinkedHashSet is better than HashSet or List.
Builds foundation for safe and predictable train composition logic.
