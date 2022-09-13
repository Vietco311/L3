import re

def full_name(str_arg:str) -> str:
    """transform a full name from lower case to upper case for the name and only the first for the surname

    Args:
        str_arg (str): full name

    Returns:
        str: trnasformed full name
    """
    x = str_arg.split()
    name = x[0].upper()
    surname = x[1].replace(x[1][0], x[1][0].upper())
    return name + " " + surname

def is_mail(str_arg: str):
    """Check the validity of an email

    Args:
        str_arg (str): the email
    """
    valid = 1
    code = 0
    x = str_arg.split("@")
    print(len(x))
    if len(x) < 3:
        if x[0][0] == "." or x[0][-1] == ".":
            valid = 0
            code = 1
            print("le mail n’est pas valide, le corp n’est pas valide0")
        for i in range(len(x[0])):
            if x[0][i] == "." and x[0][i-1] == ".":
                valid = 0
                code = 1
                print("le mail n’est pas valide, le corp n’est pas valide1")
        if re.match('[\-\w]', x[0]) == False:
            valid = 0
            code = 1
            print("le mail n’est pas valide, le corp n’est pas valide2")
        for i in range(len(x[1])):
            if x[1][i] == "." and x[1][i-1] == ".":
                valid = 0
                code = 3
                print("le mail n’est pas valide, le domaine n’est pas valide1")
        if re.match('[a-zA-Z0-9\-\.]', x[1]) == False:
            valid = 0
            code = 3
            print("le mail n’est pas valide, le domaine n’est pas valide2")
        if x[1][-1] == "." or "." not in x[1]:
            valid = 0
            code = 4
            print("le mail n’est pas valide, problème de point dans le domaine")
    else:
        valid = 0
        code = 2
        print("le mail n’est pas valide, problème d'@")
    
    return (valid, code)

def test():
    print(is_mail("bisgambiglia@@univ-corse.fr"))
    print(full_name("colin anthony"))

test()