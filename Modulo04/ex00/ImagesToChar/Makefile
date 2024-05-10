NAME = Main

SRCS = src/java/edu/roma42/printer/app/Main.java \
       src/java/edu/roma42/printer/logic/ImageConverter.java \

OBJS = $(SRCS:.java=.class)

OBJDIR = target/

# Regola predefinita
all: $(OBJS)

# Regola per compilare i file .java in .class
%.class: %.java
	javac -d $(OBJDIR) $(SRCS)

# Regola per pulire la directory obj
clean:
	rm -r $(OBJDIR)\edu

.PHONY: all clean