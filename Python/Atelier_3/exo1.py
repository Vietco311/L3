import re

def full_name(str_arg:str) -> str:
    """transform a full name from lower case to upper case for the name and only the first letter for the surname

    Args:
        str_arg (str): full name

    Returns:
        str: trnasformed full name
    """
    x = str_arg.split()
    name = x[0].upper()
    surname = x[1].replace(x[1][0], x[1][0].upper())
    return name + " " + surname

def is_mail(str_arg: str) -> tuple:
    """Check the validity of an email

    Args:
        str_arg (str): the email
    """
    valid = 1
    code = 0
    corps_domaine = str_arg.split("@")
    print(len(corps_domaine))
    if len(corps_domaine) < 3:
        if corps_domaine[0][0] == "." or corps_domaine[0][-1] == ".":
            valid = 0
            code = 1
            print("le mail n’est pas valide, le corps n’est pas valide0")
        for i in range(len(corps_domaine[0])):
            if corps_domaine[0][i] == "." and corps_domaine[0][i-1] == ".":
                valid = 0
                code = 1
                print("le mail n’est pas valide, le corps n’est pas valide1")
        if re.match('[\-\w]', corps_domaine[0]) == False:
            valid = 0
            code = 1
            print("le mail n’est pas valide, le corps n’est pas valide2")
        for i in range(len(corps_domaine[1])):
            if corps_domaine[1][i] == "." and corps_domaine[1][i-1] == ".":
                valid = 0
                code = 3
                print("le mail n’est pas valide, le domaine n’est pas valide1")
        if re.match('[a-zA-Z0-9\-\.]', corps_domaine[1]) == False:
            valid = 0
            code = 3
            print("le mail n’est pas valide, le domaine n’est pas valide2")
        if corps_domaine[1][-1] == "." or "." not in corps_domaine[1]:
            valid = 0
            code = 4
            print("le mail n’est pas valide, problème de point dans le domaine")
    else:
        valid = 0
        code = 2
        print("le mail n’est pas valide, problème d'@")
    
    return (valid, code)

def test():
    print(is_mail("ant.colin311@gmail.com"))
    print(full_name("colin anthony"))

test()