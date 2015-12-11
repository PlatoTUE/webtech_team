## Checkersboard:
Board looks like:
-1-2-3-4-5
6-7-8-9-10
...
...
21-22-23-24-25

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
content: file (must be a valid .jar file)
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
params: ai_id (int), checkers_board (JSON encoded)
result: result_id (int), estimated_completion (datetime string)
response: 404 Ai not found, 202 Accepted

GET /move
params: ai_id (int), result_id (int)
200 result (JSON): {'checkers_board': [[stone1], [stone2], ...]}
202 result (JSON): {"estimated_completion": "<datetime string>"}
response: 200 Ok, 202 Accepted, 404 Ai not found, ?410 Gone


## Database:
pk stands for primary key and is just an integer used by django.
if an field has {} it means it's an foreign key
if an field has [] it says what kind of data is stored
The user is handled by Django, this fills in the username and password

User = (pk)
Ai = (pk, owner{pk of User}, file, avg_computation_time)
Move = (pk, ai{pk of Ai}, input, created[timestamp], estimated_completion[timestamp])

the Move.input has the JSON encoded string of the checkersboard that was used to create the move.


## Processing
The ai's are uploaded as .jar files. That should be callable with some chessboard and
should then write to some file.
As soon as an user want the ai to calculate some move an `Move` instance is created
and the jar file is called in a seperate process. When the process is finished it
writes the ouput to some file (/output/Move.pk.json)
Then when a GET /move is issued it simply checks if the file is there or not and
returns the contents.
The estimation is given based on the previous calls


## Front-end
- Login view. Set username and password
- Loggedin view. See your API's. And maby their statistics
- Play game setup view. Choose two AI's or play against an AI. ?Define who may start
- Game view. jQuery does API requests and plays the game. An simple table provides the field
- Homepage view. Explanation and overview of all the views.