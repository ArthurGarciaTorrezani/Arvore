import random
from collections import OrderedDict, Counter, ChainMap, defaultdict

def criar_dicionario(): 
    dicionario = {
        'chave1': 'valor1',
        'chave2': 'valor2',
        'chave3': 'valor3',
    }
    return dicionario

def imprimir_dicionario(): 
    dicionario = criar_dicionario()
    print(dicionario)

def funcao_hash(chave, modulo): 
    return chave % modulo

def imprimir_hash(): 
    for _ in range(10):
        modulo = random.randint(2, 10)
        chave = random.randrange(3, 15)
        hash_calculado = funcao_hash(chave, modulo)
        print(f'Chave da HashTable: {hash_calculado}')

def criar_ordered_dict():
    dicionario = OrderedDict()
    dicionario["chave1"] = 1
    dicionario["chave2"] = 2
    return dicionario

def imprimir_ordered_dict():
    dicionario = criar_ordered_dict()
    print(list(dicionario.keys()))

def criar_default_dict():
    dicionario = defaultdict(float)
    return dicionario

def imprimir_default_dict():
    dicionario = criar_default_dict()
    print(dicionario["valor1"])

def criar_counter_dict():
    dicionario = Counter(["valor", "valor", "valor", "valor1"])
    return dicionario

def imprimir_counter_dict():
    dicionario = criar_counter_dict()
    print(dicionario["valor"])

def criar_set_dict():
    dicionario = set(["valor", "valor", "valor", "valor1"])
    return dicionario

def imprimir_set_dict():
    dicionario = criar_set_dict()
    print(dicionario)

def criar_chain_map():
    primeiro_dict = criar_d
