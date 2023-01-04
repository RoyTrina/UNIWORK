import time					
import random						
var1 = raw_input("#! ")

library = [
	['hello', 'Howdy'],
	['hi', 'Hey'],
	['hey', 'Hi'],
	['ola', 5, 'Hi', 'Hey', 'Banana', 'Lol', '#TuringTest'],
	['are you a computer?', 'Definitely not.'],
	[' ', ' ']
]
while 1:
        for i in range(0, 5):
                if library[i][0] == var1.lower():
                        if isinstance(library[i][1], int):
                                k = random.randint(2, library[i][1] + 1)
                                time.sleep(random.randint(20, 45)/10)
                                print("#? " + library[i][k])
                                
		else:
                        time.sleep(random.randint(20, 45)/10)
                        print("#? " + library[i][1])			
	var1 = raw_input("#! ")	


var1 = raw_input(" press enter to terminate ")	
