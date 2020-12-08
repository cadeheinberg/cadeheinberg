#!/bin/bash

echo "Content-type:text/json"
echo ""
java -cp ../JavaFiles/. GetOpenTickets $QUERY_STRING