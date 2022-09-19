
intrepretation = {
        "famine":{
            "min": 0,
            "max": 16.49
        },
        "maigreur":{
            "min": 16.5,
            "max": 18.49
        },
        "normale":{
            "min": 18.5,
            "max": 24.99
        },
        "surpoids":{
            "min": 25,
            "max": 29.99
        },
        "obésité modérée":{
            "min": 30,
            "max": 34.99
        },
        "obésité sévère":{
            "min": 35,
            "max": 39.99
        },
        "obésité morbide":{
            "min": 40
        }
    }

def message_imc(imc):
    
    if imc >= 40:
        return "obésité sévère"
    else:    
        for cle, value in intrepretation.items():
            if imc > value['min'] and imc < value['max']:
                return cle
def imcTest():
    print(message_imc(15))
    print(message_imc(32))
    print(message_imc(23))
    print(message_imc(41))

imcTest()