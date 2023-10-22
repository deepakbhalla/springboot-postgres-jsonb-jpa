# springboot-postgres-jsonb-jpa
Spring boot application to demonstrate the JSONB data type used in PostgreSQL database using Springboot JPA implementation.

JSON data types are for storing JSON (JavaScript Object Notation) data. Such data can also be stored as text, but the 
JSON data types have the advantage of enforcing that each stored value is valid according to the JSON rules. There are 
also assorted JSON-specific functions and operators available for data stored in these data types.

PostgreSQL offers two types for storing JSON data: 

- JSON 
- JSONB. 

To implement efficient query mechanisms for these 
data types, PostgreSQL also provides the jsonpath data type.

The json and jsonb data types accept almost identical sets of values as input. The major practical difference is one 
of efficiency. The json data type stores an exact copy of the input text, which processing functions must reparse on 
each execution; while jsonb data is stored in a decomposed binary format that makes it slightly slower to input due to 
added conversion overhead, but significantly faster to process, since no reparsing is needed. jsonb also supports 
indexing, which can be a significant advantage.

Because the json type stores an exact copy of the input text, it will preserve semantically-insignificant white space 
between tokens, as well as the order of keys within JSON objects. Also, if a JSON object within the value contains the 
same key more than once, all the key/value pairs are kept. (The processing functions consider the last value as the 
operative one.) By contrast, jsonb does not preserve white space, does not preserve the order of object keys, and does 
not keep duplicate object keys. If duplicate keys are specified in the input, only the last value is kept.

In general, most applications should prefer to store JSON data as jsonb, unless there are quite specialized needs, such 
as legacy assumptions about ordering of object keys.

JSONB is a "better" version of JSON.

Let's look at an example:

- JSON

![img.png](screenshots/19_json_data_type_example.png)

- JSONB

![img.png](screenshots/20_jsonb_data_type_example.png)

In summary,

1. JSON stores white space, and that is why we can see spaces when key "a" is stored, while JSONB does not.
2. JSON stores all the values of a key. This is the reason you can see multiple values (2 and 1) against the key "a" , while JSONB only "stores" the last value.
3. JSON maintains the order in which elements are inserted, while JSONB maintains the "sorted" order.
4. JSONB objects are stored as a decompressed binary as opposed to "raw data" in JSON, where no reparsing of data is required during retrieval.
5. JSONB also supports indexing, which can be a significant advantage.

References:

https://www.postgresql.org/docs/current/datatype-json.html