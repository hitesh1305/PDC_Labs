
#include <stdio.h>
#include <omp.h>
#include <string.h>

#define MAX_MESSAGES 5

// Shared topic
char topic[MAX_MESSAGES][100];

// Number of messages published
int messageCount = 0;

int main()
{
    printf("=============================================\n");
    printf(" Publish-Subscribe Messaging System\n");
    printf(" Using OpenMP\n");
    printf("=============================================\n");

    #pragma omp parallel sections
    {
        // Publisher
        #pragma omp section
        {
            char *messages[] = {
                "PDC Lecture at 9:00 AM",
                "Submit PDC Journal",
                "PDC Assignment Due Today",
                "Practical Exam on Friday",
                "Attend PDC Lecture Regularly"
            };

            for (int i = 0; i < MAX_MESSAGES; i++)
            {
                #pragma omp critical
                {
                    strcpy(topic[messageCount], messages[i]);
                    messageCount++;

                    printf("\nPublisher: %s", messages[i]);
                }
            }
        }

        // Subscriber 1
        #pragma omp section
        {
            printf("\nSubscriber 1 is connected to the topic.\n");
        }

        // Subscriber 2
        #pragma omp section
        {
            printf("Subscriber 2 is connected to the topic.\n");
        }
    }

    // Subscribers receive messages
    #pragma omp parallel sections
    {
        #pragma omp section
        {
            printf("\n\n========== Subscriber 1 ==========\n");

            for (int i = 0; i < messageCount; i++)
            {
                printf("Subscriber 1 received: %s\n", topic[i]);
            }
        }

        #pragma omp section
        {
            printf("\n========== Subscriber 2 ==========\n");

            for (int i = 0; i < messageCount; i++)
            {
                printf("Subscriber 2 received: %s\n", topic[i]);
            }
        }
    }

    printf("\nAll messages delivered successfully.\n");

    return 0;
}
