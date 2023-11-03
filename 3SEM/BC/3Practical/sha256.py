import hashlib

string="John Doe"
print("String : ", end ="")
print(string)
encoded=string.encode()
print("Encoded Sting : ",encoded)
result = hashlib.sha256(encoded)
print("Hash Value : ", end ="")
print(result)
print("Hexadecimal equivalent: ",result.hexdigest())
print("Digest Size : ", end ="")
print(result.digest_size)


print("Block Size : ", end ="")
print(result.block_size)
