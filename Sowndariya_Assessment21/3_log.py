import re
try:
    file=open("server_log.txt","r")
    content=file.read()
    lines=content.splitlines()
    total_lines=len(lines)
    total_words=len(content.split())
    total_char=len(content)
    vowels="aeiouAEIOU"
    total_vowels=0

#count vowel
    for i in content:
        if i in vowels:
            total_vowels+=1
    print("count",total_vowels)

    info = len(re.findall(r'INFO', content))
    warning = len(re.findall(r'WARNING', content))
    error = len(re.findall(r'ERROR', content))
    critical = len(re.findall(r'CRITICAL', content))
    alerts=[]
    for i in lines:
            if "[ERROR]"in i or "[CRITICAL]" in i:
                alerts.append(i)

    #create log_report in write 
    report=open("log_report.txt","w")
    report.write("Total Lines : "+str(total_lines)+"\n")
    report.write("Total Words: "+str(total_words)+"\n")
    report.write("Total char: "+str(total_char)+"\n")
    report.write("Total vowels: "+str(total_vowels)+"\n")
    #error types
    report.write("INFO : " +str(info)+"\n")
    report.write("WARNING : "+str(warning)+"\n")
    report.write("ERROR : "+str(error)+"\n")
    report.write("CRITICAL : "+str(critical)+"\n")
    report.write("--- ALERTS ---\n")
    for line in alerts:
        report.write(line+"\n")
    print("Report generated successfully")

except FileNotFoundError:
    print("File not found")

except Exception as e:
    print("Error:", e)

finally:
    try:
        file.close()
        report.close()
    except:
        pass