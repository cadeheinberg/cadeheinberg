#!/bin/bash

echo "Content-type:text/html"
echo ""
java -cp ../JavaFiles/. CreateTicket $QUERY_STRING