f=open(r"input.txt", "r") 
print('\n'.join(__import__('textwrap').fill(line, 80) for line in f ))