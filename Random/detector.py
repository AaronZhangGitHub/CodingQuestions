def main(eventList):
    counter = 1
    currentHighInoviceNumber = -1
    contractorHighestInvoiceAtStart = {}
    fradulantList = []
    for event in eventList:
        splitEvent = event.split(';')
        #handle if it is a START
        if 'START' in splitEvent[1]:
            contractorHighestInvoiceAtStart[splitEvent[0]]=currentHighInoviceNumber
        elif ',' in splitEvent[1]:
            #Handle if it has more than 1 invoice
            invoiceList = splitEvent[1].split(',')
            #loop through invoice list to find high and low values
            low = 300001
            high = -1
            for invoice in invoiceList:
                invoiceInt = int(invoice)
                if(invoiceInt>high):
                    high = invoiceInt
                if(invoiceInt<low):
                    low = invoiceInt
            #Now have high and low values
            #check if there is a violation
            if low<contractorHighestInvoiceAtStart[splitEvent[0]]:
                fradulantList.append("%i;%s;SUSPICIOUS_BATCH"%(counter,splitEvent[0]))
            elif high>currentHighInoviceNumber:
                currentHighInoviceNumber=high
        else:
            #only one invoice
            if int(splitEvent[1])<contractorHighestInvoiceAtStart[splitEvent[0]]:
                #Current number is possibly fradulant
                fradulantList.append("%i;%s;SHORTENED_JOB"%(counter,splitEvent[0]))
            elif int(splitEvent[1])>currentHighInoviceNumber:
                #Not fradulant, but needs to be set as highest invoice number
                currentHighInoviceNumber=int(splitEvent[1])
        counter+=1
        print(contractorHighestInvoiceAtStart)
    return fradulantList



inputList = ["Alice;START","Bob;START","Bob;1","Carson;START","Alice;15","Carson;6","David;START","David;24","Evil;START","Evil;24","Evil;START","Evil;18","Fiona;START"]

print(main(inputList))
