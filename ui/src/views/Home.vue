<template>
    <div>
        <v-container>
            <v-col>
                <v-row justify="center">
                    <v-card flat color="primary">
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="secondary" to="/start">Start a new game</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="secondary" to="/join">Join a game</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-row>
            </v-col>
        </v-container>
    </div>
</template>
<script>
export default {};
</script>

<style>
</style>