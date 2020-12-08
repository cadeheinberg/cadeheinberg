#!/bin/bash

echo "Content-type:text/json"
echo ""
java -cp ../JavaFiles/. GetUserTickets $QUERY_STRING