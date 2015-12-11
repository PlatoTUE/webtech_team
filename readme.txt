## Checkersboard:
Board looks like:
-1-2-3-4-5
6-7-8-9-10
...
...
21-22-23-24-25
where the number are the playable fields and the - are the non playable fields

And is encoded in JSON like an list of all the pieces on the board:
[
    [black/white, normal/queen, place (between 1 and 25)],
    [1, 0, 9],  //white piece on place 9
    [0, 1, 10], //an black double piece on place 10
    ...,
]


## API:
response: 400 bad request

POST /ai
params: user_id
content: file: (any file name, but must be a valid .java file)
result: ai_id
response: 404 User not found, 201 Created

DELETE /ai
params: user_id, ai_id
response: 404 User/Ai not found, 200 Ok=Ai deleted

GET /ai
params: user_id (optional)
result (JSON): {'ai_ids': [id1, id2, id3, ...]}
response: 404 User not found, 200 Ok

PUT /move
params: ai_id (int), checkers_board (JSON encoded), whites_turn
result: result_id (int), estimated_completion (datetime string)
response: 404 Ai not found, 202 Accepted

GET /move
params: ai_id (int), result_id (int)
200 result (JSON): {'checkers_board': [[stone1], [stone2], ...]}
202 result (JSON): {"estimated_completion": "<datetime string>"}
response: 200 Ok, 202 Accepted, 404 Ai not found, ?410 Gone
comments: We return an array so that we can easily implement an fair AI. After this we should make something that checks if the moves are valid or not.

## Database:
pk stands for primary key and is just an integer used by django.
if an field has {} it means it's an foreign key
if an field has [] it says what kind of data is stored
The user is handled by Django, this fills in the username and password

The models:
User = (pk)
Ai = (pk, owner{pk of User}, file, avg_computation_time)
Move = (pk, ai{pk of Ai}, checkersboard, whites_turn[boolean], created[timestamp], estimated_completion[timestamp])

the Move.checkersboard has the JSON encoded string of the checkersboard that was used to create the move.
the Move.whites_turn denotes who's turn it is


## Processing
The ai's are uploaded as .java files implementing the DraughtsPlayer class.
This is then turned into an executable .jar file with input and ouput parameters that manages the calculation
someting like: ai_id.jar --checkers_board [[1,1,4],[0,1,5],[0,0,18]] --turn 1 --output folder/ai_id.json
We intially use the framework from AI to initiate the calculation and check the result.

As soon as an user want the ai to calculate some move an `Move` instance is created and the java jar is called in a seperate process. 
When the process is finished it writes the ouput to some file (/output/ai_id.json)
Then when a GET /move is issued it simply checks if the file is there or not and returns the contents.
The estimation is given based on the previous calls.


## Front-end
- Login view. Set username and password
- Loggedin view. See your API's. And maby their statistics
- Play game setup view. Choose two AI's or play against an AI. ?Define who may start
- Game view. jQuery does API requests and plays the game. An simple table provides the field
- Homepage view. Explanation and overview of all the views.
