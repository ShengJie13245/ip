# Sss User Guide

Sss is a chatbot that allows users to manage multiple tasks, via a Command Line Interface

## Quick start
1. Ensure you have Java `17` or above installed in your computer.
1. Download the latest `.jar` file from [GitHub](https://github.com/ShengJie13245/ip)
1. Copy the file to any folder
1. Open a command terminal, `cd` into the folder and use `java -jar ShengJieip.jar`command to run the application
1. Refer to Features below for details of each command

## Features

### List all tasks: `list`
Shows all currently tracked tasks.

Format: `list`

### Marking task: `mark`
Marks specified task as completed.

Format: `mark INDEX`

Example: `mark 1`

### Unmarking task: `unmark`
Marks specified task as incomplete.

Format: `unmark INDEX`

Example: `unmark 1`

### Deleting task: `delete`
Deletes specified task.

Format: `delete INDEX`

Example: `delete 1`

### Adding a todo task: `todo`
Adds a todo task to the list of tracked tasks.

Format: `todo TASK_DESCRIPTION`

Example: `todo return books`

### Adding a todo task: `deadline`
Adds a todo task to the list of tracked tasks.

Format: `deadline TASK_DESCRIPTION /by DATE`

Example: `deadline submit homework /by 10th March`

### Adding a todo task: `event`
Adds a todo task to the list of tracked tasks.

Format: `event TASK_DESCRIPTION /from STARTING_DATE /to ENDING_DATE`

Example: `event attend lecture /from 6th Feb 5pm /to 6th Feb 7pm`

### Searching tasks by keyword: `find`
Lists all tasks that contains the keyword.

Format: `find KEYWORD [MORE_KEYWORDS]`

Example: 
    * `find books`
    * `find return book`

### Exiting the program: `bye`
Terminates the program.

Format: `bye`

### Saving the data
Sss saves all data in the hard disk automatically after any changes has been made to the data.

### Editing the data file
Sss data is saved automatically as a txt file [Jar file location]/saves/taskdata.txt
// Feature details


## Command Summary
Command | Format, Examples
------- | ----------------
**list** | `list`
**mark** | `mark INDEX`<br> e.g. `mark 1`
**unmark** | `unmark INDEX`<br> e.g. `unmark 1`
**delete** | `delete INDEX`<br> e.g. `delete 1`
**todo** | `todo TASK_DESCRIPTION`<br> e.g. `todo return books`
**deadline** | `deadline TASK_DESCRIPTION /by DATE`<br> e.g. `deadline submit homework /by 10th March`
**event** | `event TASK_DESCRIPTION /from STARTING_DATE /to ENDING_DATE`<br> e.g. `event attend lecture /from 6th Feb 5pm /to 6th Feb 7pm`
**find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g. `find return book`
**bye** | `bye`
